package com.elim.learn.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文章类，其与User是多对一的关系，多篇文章对应同一个作者User。
 *
 * @author elim
 *
 * @date 2016年1月2日 下午9:25:16
 *
 */
@Table(name="t_article")
@Entity
public class Article {

	private Integer id;
	private String title;
	private String content;
	private User author;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * ManyToOne用于指定多对一关系。ManyToOne等这样的对应关系将使用@JoinColumn注解来指定对应关联的字段的信息，而不能再使用@Column，
	 * 默认不指定时将会采用属性名加_关联实体主键名的方式作为关联字段，如在此示例中即使不使用@JoinColumn指定关联的字段名，默认也将关联字段命名为author_id，因为关联的属性是author，
	 * 关联的实体Author的主键名是id。<br/>
	 * 可以通过@ManyToOne的fetch属性指定一的一方是懒加载还是一开始就加载出来。<br/>
	 * 可以通过@ManyToOne的cascade属性指定对一的一方的级联形式，CascadeType.ALL表示所有的可级联的操作都将级联
	 * @return
	 */
	@JoinColumn(name="author_id")
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
