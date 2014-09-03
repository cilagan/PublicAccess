package gov.research.publicaccess.controller;

import gov.research.publicaccess.model.PublicationMetadata;
import gov.research.publicaccess.model.Records;
import gov.research.publicaccess.util.DoePagesUtil;
import gov.research.publicaccess.util.MockDataUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nsfpages")
public class PublicAccessController {
	
	@RequestMapping(value="/nsfpagesxml", method = RequestMethod.GET)
	public @ResponseBody Records getPublicationMetadata(@RequestParam String awardId){
		
		Records records = new Records();
		List<PublicationMetadata> recordList = new ArrayList<PublicationMetadata>();
		recordList.add(MockDataUtil.getPublicationMetadataMock());
		records.setRecords(recordList);
		
		
		return records;
	}
	
	@RequestMapping(value="/nsfpagesxmlBatch", method = RequestMethod.GET)
	public @ResponseBody Records getPublicationBatchLoad(@RequestParam long batchCallLastTimestamp){
		
		Date updateDate = new Date();
		System.out.println("Update Date: " + updateDate);
		
		Records records = new Records();
		records.setRecords(MockDataUtil.getPublicationMetadataList());
		
		return records;
	}
	
	@RequestMapping(value="/award/{awardId}", method = RequestMethod.GET)
	public String getPublicationsByAwardId(@PathVariable String awardId, ModelMap model){
		List<PublicationMetadata> pubList = new ArrayList<PublicationMetadata>();
		
		pubList = MockDataUtil.getPublicationMetadataList();
		model.addAttribute("publicationMetadataList", pubList);
		
		return "list";
	}
	
	@RequestMapping(value="/topic/{awardId}", method = RequestMethod.GET)
	public String getPublicationsByTopic(@PathVariable String awardId, ModelMap model){
		
		Map<String, PublicationMetadata> pubMetaDataMap = DoePagesUtil.getPublicationsByAwardId(awardId);
		model.addAttribute("pubMetadataMap", pubMetaDataMap);
		
		return "map";
	}
	
	@RequestMapping(value="/topic/batch", method = RequestMethod.GET)
	public String getPublicationsByBatch(@RequestParam String batchCallLastTimestamp, ModelMap model){
		
		//convert param to date
		Timestamp ts = convertToTimeStamp(batchCallLastTimestamp);
		
		Map<String, PublicationMetadata> pubMetaDataMap = DoePagesUtil.getPublicationsByLastBatchTimeStamp(ts.getTime());
		model.addAttribute("pubMetadataMap", pubMetaDataMap);
		System.out.println("DateTime: " + batchCallLastTimestamp);
		System.out.println("TimeStamp: " + ts);
		System.out.println("TimeStamp - Long: " + ts.getTime());
		
		return "map";
	}
	
	private Timestamp convertToTimeStamp(String dateTime){
		String param = StringUtils.replace(dateTime, "_", ":");
		DateTime dt = new DateTime(param);
		Timestamp ts = new Timestamp(dt.getMillis());
		return ts;
	}
}
