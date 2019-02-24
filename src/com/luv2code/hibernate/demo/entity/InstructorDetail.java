package com.luv2code.hibernate.demo.entity;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> 520321d1b15c4fb8277cc8ee8bd4d8037f87c35f
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.OneToOne;
=======
>>>>>>> 520321d1b15c4fb8277cc8ee8bd4d8037f87c35f
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// annotate the class as an entity and map to db 
	
	// define the fields 
	
	// annotate the fields with db column names 
	
	// create constructors
	
	// generate getters/setters and toString
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
<<<<<<< HEAD
	// add new field for instructor (and getters/setters)
	// add onetoone bidirectional mapping
	@OneToOne(mappedBy="instructorDetail", 
			cascade= {CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH})
	private Instructor instructor;
	
=======
>>>>>>> 520321d1b15c4fb8277cc8ee8bd4d8037f87c35f
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
<<<<<<< HEAD
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
=======
>>>>>>> 520321d1b15c4fb8277cc8ee8bd4d8037f87c35f

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
}
