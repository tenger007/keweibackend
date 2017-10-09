package cn.cncic.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expert_article {
	@Id @GeneratedValue
	private long id; 
	private String pub_type; //出版物类型PT 
	private String author;//作者AU
	private String author_name; //作者全名AF
	private String book_author; //书籍作者BA
	private String team_author; //团队作者CA
	private String book_team_author;//书籍团队作者GP
	private String editor;//编者 BE
	private String doc_title;//文献标题TI
	private String pub_name;//出版物名称SO
	private String book_title;//从书标题SE
	private String book_title2;//从书副标题BS
	private String language;//语种LA
	private String doc_type;//文献类型DT
	private String meeting_title;//会议标题CT
	private String meeting_date;//会议日期CY
	private String meeting_addr;//会议地点CL
	private String meeting_offers;//会议赞助方SP
	private String meeting_hoster;//会议主办方HO
	private String author_keyword;//作者关键词DE
	private String Keywords_Plus;//Keyword
	private String summary; //摘要AB
	private String author_addr;//作者地址C1
	private String tel_author_addr;
	private String email;//电子邮箱地址EM
	private String sub_unit_num;//基金组织机构和申授权号FU
	private String sub_text;//基金资助正文FX
	private String refer_doc;//引用参考文献CR
	private String refer_count_doc;//引用的参考文献数NR
	private String refer_count;//Web of Science 被引频的次数TC
	private String refer_sum;//被引频次总数（Wos、BCI和CSCD）z9
	private String publisher;//出版商PU
	private String publisher_city;//出版商所在城市PI
	private String publisher_addr;//出版商地址PA
	private String issn;//国际标准期刊号（ISSN）SN
	private String isbn;//国际标准书号（ISBN）BN
	private String source_doc_name;//长度为29个字符的来源文献名称缩写J9
	private String source_iso_name;//ISO来源文献名称缩写JI
	private String pub_date;//出版日期PD
	private int pub_year;//出版年PY
	private String volumn;//卷VL
	private String issue;//期IS
	private String spe_issue;//特刊SI
	private String child_issue;//子辑PN
	private String add_issue;//增刊SU
	private String begin_page;//开始页BP
	private	String end_page;//结束页EP
	private String doc_num; //文献编号
	private String doi;//书对象标识符（DOI）DI
	private String book_doi;//书籍的数字对象标识符
	private String count_page;//页数PG
	private String science_type;//Web o Science 类别WC
	private String subj_type;//学科类别SC
	private String doc_tran_num;//文献传递号GA
	private String collect_num;//入藏号UT
	private String recently_180_use;//最近180天使用次数u1
	private String now_use;//至今使用次数u2
	private Long jsd_expert_id;
	
	public Long getJsd_expert_id() {
		return jsd_expert_id;
	}
	public void setJsd_expert_id(Long jsd_expert_id) {
		this.jsd_expert_id = jsd_expert_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPub_type() {
		return pub_type;
	}
	public void setPub_type(String pub_type) {
		this.pub_type = pub_type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getTeam_author() {
		return team_author;
	}
	public void setTeam_author(String team_author) {
		this.team_author = team_author;
	}
	public String getBook_team_author() {
		return book_team_author;
	}
	public void setBook_team_author(String book_team_author) {
		this.book_team_author = book_team_author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getPub_name() {
		return pub_name;
	}
	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_title2() {
		return book_title2;
	}
	public void setBook_title2(String book_title2) {
		this.book_title2 = book_title2;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDoc_type() {
		return doc_type;
	}
	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}
	public String getMeeting_title() {
		return meeting_title;
	}
	public void setMeeting_title(String meeting_title) {
		this.meeting_title = meeting_title;
	}
	public String getMeeting_date() {
		return meeting_date;
	}
	public void setMeeting_date(String meeting_date) {
		this.meeting_date = meeting_date;
	}
	public String getMeeting_addr() {
		return meeting_addr;
	}
	public void setMeeting_addr(String meeting_addr) {
		this.meeting_addr = meeting_addr;
	}
	public String getMeeting_offers() {
		return meeting_offers;
	}
	public void setMeeting_offers(String meeting_offers) {
		this.meeting_offers = meeting_offers;
	}
	public String getMeeting_hoster() {
		return meeting_hoster;
	}
	public void setMeeting_hoster(String meeting_hoster) {
		this.meeting_hoster = meeting_hoster;
	}
	public String getAuthor_keyword() {
		return author_keyword;
	}
	public void setAuthor_keyword(String author_keyword) {
		this.author_keyword = author_keyword;
	}
	
	public String getKeywords_Plus() {
		return Keywords_Plus;
	}
	public void setKeywords_Plus(String keywords_Plus) {
		Keywords_Plus = keywords_Plus;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAuthor_addr() {
		return author_addr;
	}
	public void setAuthor_addr(String author_addr) {
		this.author_addr = author_addr;
	}
	public String getTel_author_addr() {
		return tel_author_addr;
	}
	public void setTel_author_addr(String tel_author_addr) {
		this.tel_author_addr = tel_author_addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSub_unit_num() {
		return sub_unit_num;
	}
	public void setSub_unit_num(String sub_unit_num) {
		this.sub_unit_num = sub_unit_num;
	}
	public String getSub_text() {
		return sub_text;
	}
	public void setSub_text(String sub_text) {
		this.sub_text = sub_text;
	}
	public String getRefer_doc() {
		return refer_doc;
	}
	public void setRefer_doc(String refer_doc) {
		this.refer_doc = refer_doc;
	}
	public String getRefer_count_doc() {
		return refer_count_doc;
	}
	public void setRefer_count_doc(String refer_count_doc) {
		this.refer_count_doc = refer_count_doc;
	}
	public String getRefer_count() {
		return refer_count;
	}
	public void setRefer_count(String refer_count) {
		this.refer_count = refer_count;
	}
	public String getRefer_sum() {
		return refer_sum;
	}
	public void setRefer_sum(String refer_sum) {
		this.refer_sum = refer_sum;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisher_city() {
		return publisher_city;
	}
	public void setPublisher_city(String publisher_city) {
		this.publisher_city = publisher_city;
	}
	public String getPublisher_addr() {
		return publisher_addr;
	}
	public void setPublisher_addr(String publisher_addr) {
		this.publisher_addr = publisher_addr;
	}
	public String getIssn() {
		return issn;
	}
	public void setIssn(String issn) {
		this.issn = issn;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSource_doc_name() {
		return source_doc_name;
	}
	public void setSource_doc_name(String source_doc_name) {
		this.source_doc_name = source_doc_name;
	}
	public String getSource_iso_name() {
		return source_iso_name;
	}
	public void setSource_iso_name(String source_iso_name) {
		this.source_iso_name = source_iso_name;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	
	public int getPub_year() {
		return pub_year;
	}
	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}
	public String getVolumn() {
		return volumn;
	}
	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getSpe_issue() {
		return spe_issue;
	}
	public void setSpe_issue(String spe_issue) {
		this.spe_issue = spe_issue;
	}
	public String getChild_issue() {
		return child_issue;
	}
	public void setChild_issue(String child_issue) {
		this.child_issue = child_issue;
	}
	public String getAdd_issue() {
		return add_issue;
	}
	public void setAdd_issue(String add_issue) {
		this.add_issue = add_issue;
	}
	public String getBegin_page() {
		return begin_page;
	}
	public void setBegin_page(String begin_page) {
		this.begin_page = begin_page;
	}
	public String getEnd_page() {
		return end_page;
	}
	public void setEnd_page(String end_page) {
		this.end_page = end_page;
	}
	public String getDoc_num() {
		return doc_num;
	}
	public void setDoc_num(String doc_num) {
		this.doc_num = doc_num;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getBook_doi() {
		return book_doi;
	}
	public void setBook_doi(String book_doi) {
		this.book_doi = book_doi;
	}
		public String getCount_page() {
		return count_page;
	}
	public void setCount_page(String count_page) {
		this.count_page = count_page;
	}
	public String getScience_type() {
		return science_type;
	}
	public void setScience_type(String science_type) {
		this.science_type = science_type;
	}
	public String getSubj_type() {
		return subj_type;
	}
	public void setSubj_type(String subj_type) {
		this.subj_type = subj_type;
	}
	public String getDoc_tran_num() {
		return doc_tran_num;
	}
	public void setDoc_tran_num(String doc_tran_num) {
		this.doc_tran_num = doc_tran_num;
	}
	public String getCollect_num() {
		return collect_num;
	}
	public void setCollect_num(String collect_num) {
		this.collect_num = collect_num;
	}
	public String getRecently_180_use() {
		return recently_180_use;
	}
	public void setRecently_180_use(String recently_180_use) {
		this.recently_180_use = recently_180_use;
	}
	public String getNow_use() {
		return now_use;
	}
	public void setNow_use(String now_use) {
		this.now_use = now_use;
	}
	
}	
