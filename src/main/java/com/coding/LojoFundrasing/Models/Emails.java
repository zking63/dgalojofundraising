package com.coding.LojoFundrasing.Models;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.criteria.Path;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name="emails")
public class Emails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String emailName;
	private Long openers;
	private Long recipients;
	private String list;
	private String excludedList;
	private Long clicks;
	private Long bounces;
	private Long unsubscribers;
	private String subjectLine;
	private String sender;
	private String emailCategory;
	private String testing;
	private String Variant;
	private String link;
	private Integer recurringDonorCount;
	private Integer recurringDonationCount;
	private Double recurringRevenue;
	private Double emaildonationaverage;
	private Double emaildonationsum;
	private Integer emaildonationcount;
	private Integer emaildonorcount;
	private Double emailunsubscribeRate;
	private Double emailclickRate;
	private Double emailopenRate;
	private Double bounceRate;
	private Double emaildonationsOpens;
	private Double emaildonationsClicks;
	private Double emailclicksOpens;
	private Double emaildonorsOpens;
	private Double emaildonorsClicks;
	private String content;
	private String parentid;
	private Double tandemrevenue;
	private Integer tandemdonations;
	private Integer firsttimedonors;
	private Double firsttimedonorsOpens;
	private Double firsttimedonorsClicks;
	private Double totalrevenue;
	private Double firstrevenue;
	private Double averagefirstrevenue;
	private Integer donationsforcalculation; //this is whichever is the higher number of donations between tandem/regular. it's used to calculate average and donations/clicks, donations/opens. the aggregate of this will be used in email group to calculate email group data.  
	@DateTimeFormat(pattern ="yyyy-MM-dd kk:mm")
	private Date Emaildate;
	private String emailRefcode1;
	private String emailRefcode2;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User email_uploader;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="committees_id")
    private Committees committee;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emailgroup_id")
    private EmailGroup emailgroup;
	
    @OneToMany(fetch=FetchType.LAZY, mappedBy="emailDonation")
	private List<Donation> Emaildonations;
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="link_id")
    private Link overalllink;
    
	/*@OneToOne(mappedBy="dataemail", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Data emaildata;*/
	
	public Emails() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailName() {
		return emailName;
	}

	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}

	public Date getEmaildate() {
		return Emaildate;
	}

	public void setEmaildate(Date emaildate) {
		Emaildate = emaildate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


    public List<Donation> getEmaildonations() {
		return Emaildonations;
	}

	public void setEmaildonations(List<Donation> Emaildonations) {
		this.Emaildonations = Emaildonations;
	}

	public String getEmailDateFormatted() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm");
    	return df.format(this.Emaildate);
    }
    
	public User getEmail_uploader() {
		return email_uploader;
	}

	public void setEmail_uploader(User email_uploader) {
		this.email_uploader = email_uploader;
	}
	
	/*public Data getEmaildata() {
		return emaildata;
	}

	public void setEmaildata(Data emaildata) {
		this.emaildata = emaildata;
	}*/
	
	

	public Committees getCommittee() {
		return committee;
	}

	public void setCommittee(Committees committee) {
		this.committee = committee;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}

	public Long getOpeners() {
		return openers;
	}

	public void setOpeners(Long openers) {
		this.openers = openers;
	}

	public Long getRecipients() {
		return recipients;
	}

	public void setRecipients(Long recipients) {
		this.recipients = recipients;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getExcludedList() {
		return excludedList;
	}

	public void setExcludedList(String excludedList) {
		this.excludedList = excludedList;
	}

	public Long getClicks() {
		return clicks;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public Long getBounces() {
		return bounces;
	}

	public void setBounces(Long bounces) {
		this.bounces = bounces;
	}

	public Long getUnsubscribers() {
		return unsubscribers;
	}

	public void setUnsubscribers(Long unsubscribers) {
		this.unsubscribers = unsubscribers;
	}

	public Integer getRecurringDonorCount() {
		return recurringDonorCount;
	}

	public void setRecurringDonorCount(Integer recurringDonorCount) {
		this.recurringDonorCount = recurringDonorCount;
	}

	public Integer getRecurringDonationCount() {
		return recurringDonationCount;
	}

	public void setRecurringDonationCount(Integer recurringDonationCount) {
		this.recurringDonationCount = recurringDonationCount;
	}

	public Double getRecurringRevenue() {
		return recurringRevenue;
	}

	public void setRecurringRevenue(Double recurringRevenue) {
		this.recurringRevenue = recurringRevenue;
	}

	public EmailGroup getEmailgroup() {
		return emailgroup;
	}

	public void setEmailgroup(EmailGroup emailgroup) {
		this.emailgroup = emailgroup;
	}

	public String getEmailRefcode2() {
		return emailRefcode2;
	}

	public void setEmailRefcode2(String emailRefcode2) {
		this.emailRefcode2 = emailRefcode2;
	}

	public Double getEmaildonationaverage() {
		return emaildonationaverage;
	}

	public void setEmaildonationaverage(Double emaildonationaverage) {
		this.emaildonationaverage = emaildonationaverage;
	}
	
	public String getEmailAverageFormatted() {
		if (this.emaildonationaverage == null) {
			this.emaildonationaverage = 0.0;
		}
		double emailAverage1 = (double) getEmaildonationaverage();
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(emailAverage1);
	}

	public Double getEmaildonationsum() {
		return emaildonationsum;
	}

	public void setEmaildonationsum(Double emaildonationsum) {
		this.emaildonationsum = emaildonationsum;
	}

	public Integer getEmaildonationcount() {
		return emaildonationcount;
	}

	public void setEmaildonationcount(Integer emaildonationcount) {
		this.emaildonationcount = emaildonationcount;
	}

	public Integer getEmaildonorcount() {
		return emaildonorcount;
	}

	public void setEmaildonorcount(Integer emaildonorcount) {
		this.emaildonorcount = emaildonorcount;
	}

	public Double getEmailunsubscribeRate() {
		return emailunsubscribeRate;
	}

	public void setEmailunsubscribeRate(Double emailunsubscribeRate) {
		this.emailunsubscribeRate = emailunsubscribeRate;
	}

	public Double getEmailclickRate() {
		return emailclickRate;
	}

	public void setEmailclickRate(Double emailclickRate) {
		this.emailclickRate = emailclickRate;
	}

	public Double getEmailopenRate() {
		return emailopenRate;
	}

	public void setEmailopenRate(Double emailopenRate) {
		this.emailopenRate = emailopenRate;
	}

	public Double getBounceRate() {
		return bounceRate;
	}

	public void setBounceRate(Double bounceRate) {
		this.bounceRate = bounceRate;
	}

	public Double getEmaildonationsOpens() {
		return emaildonationsOpens;
	}

	public void setEmaildonationsOpens(Double emaildonationsOpens) {
		this.emaildonationsOpens = emaildonationsOpens;
	}

	public Double getEmaildonationsClicks() {
		return emaildonationsClicks;
	}

	public void setEmaildonationsClicks(Double emaildonationsClicks) {
		this.emaildonationsClicks = emaildonationsClicks;
	}

	public Double getEmailclicksOpens() {
		return emailclicksOpens;
	}

	public void setEmailclicksOpens(Double emailclicksOpens) {
		this.emailclicksOpens = emailclicksOpens;
	}

	public Double getEmaildonorsOpens() {
		return emaildonorsOpens;
	}

	public void setEmaildonorsOpens(Double emaildonorsOpens) {
		this.emaildonorsOpens = emaildonorsOpens;
	}

	public Double getEmaildonorsClicks() {
		return emaildonorsClicks;
	}

	public void setEmaildonorsClicks(Double emaildonorsClicks) {
		this.emaildonorsClicks = emaildonorsClicks;
	}

	public String getEmailRefcode1() {
		return emailRefcode1;
	}

	public void setEmailRefcode1(String emailRefcode1) {
		this.emailRefcode1 = emailRefcode1;
	}

	public String getSubjectLine() {
		return subjectLine;
	}

	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getEmailCategory() {
		return emailCategory;
	}

	public void setEmailCategory(String emailCategory) {
		this.emailCategory = emailCategory;
	}

	public String getTesting() {
		return testing;
	}

	public void setTesting(String testing) {
		this.testing = testing;
	}

	public String getVariant() {
		return Variant;
	}

	public void setVariant(String variant) {
		Variant = variant;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Link getOveralllink() {
		return overalllink;
	}

	public void setOveralllink(Link overalllink) {
		this.overalllink = overalllink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Double getTandemrevenue() {
		return tandemrevenue;
	}

	public void setTandemrevenue(Double tandemrevenue) {
		this.tandemrevenue = tandemrevenue;
	}

	public Integer getTandemdonations() {
		return tandemdonations;
	}

	public void setTandemdonations(Integer tandemdonations) {
		this.tandemdonations = tandemdonations;
	}

	public Double getTotalrevenue() {
		return totalrevenue;
	}

	public void setTotalrevenue(Double totalrevenue) {
		this.totalrevenue = totalrevenue;
	}

	public Integer getDonationsforcalculation() {
		return donationsforcalculation;
	}

	public void setDonationsforcalculation(Integer donationsforcalculation) {
		this.donationsforcalculation = donationsforcalculation;
	}
	


	public String getclicksOpensFormatted() {
		Double number = this.emailclicksOpens;
		if (number == null) {
			number = 0.0;
		}
		double number1 = (double) number*100;
		DecimalFormat df = new DecimalFormat("0.000");
		String numberfinal = df.format(number1); 
		number = Double.valueOf(numberfinal);
		String percent = String.valueOf(number);
		percent = percent + "%";
		return percent;
	}
	public String getunsubscribeRateFormatted() {
		Double number = this.emailunsubscribeRate;
		if (number == null) {
			number = 0.0;
		}
		double number1 = (double) number*100;
		DecimalFormat df = new DecimalFormat("0.000");
		String numberfinal = df.format(number1); 
		number = Double.valueOf(numberfinal);
		String percent = String.valueOf(number);
		percent = percent + "%";
		return percent;
	}

	public String getOpenRateFormatted() {
		Double number = this.emailopenRate;
		if (number == null) {
			number = 0.0;
		}
		double number1 = (double) number*100;
		DecimalFormat df = new DecimalFormat("0.000");
		String numberfinal = df.format(number1); 
		number = Double.valueOf(numberfinal);
		String percent = String.valueOf(number);
		percent = percent + "%";
		return percent;
	}
	public String getSumFormatted() {
		Double number = this.emaildonationsum;
		if (number == null) {
			number = 0.0;
		}
		double number1 = (double) number;
		DecimalFormat df = new DecimalFormat("0.000");
		String numberfinal = df.format(number1); 
		number = Double.valueOf(numberfinal);
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		String revenue = myFormat.format(number);
		return revenue;
	}
	public String getTandemRevenueFormatted() {
		Double number = this.tandemrevenue;
		if (number == null) {
			number = 0.0;
		}
		double number1 = (double) number;
		DecimalFormat df = new DecimalFormat("0.000");
		String numberfinal = df.format(number1); 
		number = Double.valueOf(numberfinal);
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		String revenue = myFormat.format(number);
		return revenue;
	}
	public String getdonationsOpensFormatted() {
		Double number = this.emaildonationsOpens;
		if (number == null) {
			number = 0.0;
		}
		double number1 = (double) number*100;
		DecimalFormat df = new DecimalFormat("0.000");
		String numberfinal = df.format(number1); 
		number = Double.valueOf(numberfinal);
		String percent = String.valueOf(number);
		percent = percent + "%";
		return percent;
	}
	public String getRecipientsFormatted() {
		Long number = this.recipients;
		if (number == null) {
			number = (long) 0;
		}
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		String revenue = myFormat.format(number);
		return revenue;
	}

	public Integer getFirsttimedonors() {
		return firsttimedonors;
	}

	public void setFirsttimedonors(Integer firsttimedonors) {
		this.firsttimedonors = firsttimedonors;
	}

	public Double getFirsttimedonorsOpens() {
		return firsttimedonorsOpens;
	}

	public void setFirsttimedonorsOpens(Double firsttimedonorsOpens) {
		this.firsttimedonorsOpens = firsttimedonorsOpens;
	}

	public Double getFirsttimedonorsClicks() {
		return firsttimedonorsClicks;
	}

	public void setFirsttimedonorsClicks(Double firsttimedonorsClicks) {
		this.firsttimedonorsClicks = firsttimedonorsClicks;
	}
	public Double getFirstrevenue() {
		return firstrevenue;
	}
	public void setFirstrevenue(Double firstrevenue) {
		this.firstrevenue = firstrevenue;
	}
	public Double getAveragefirstrevenue() {
		return averagefirstrevenue;
	}
	public void setAveragefirstrevenue(Double averagefirstrevenue) {
		this.averagefirstrevenue = averagefirstrevenue;
	}
}
