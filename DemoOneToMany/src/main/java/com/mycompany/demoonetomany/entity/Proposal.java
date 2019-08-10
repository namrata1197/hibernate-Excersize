package com.mycompany.demoonetomany.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

/**
 *
 * @author namrata
 */
@Entity
@Table(name = "proposal")
@SequenceGenerator(name = "personnel_attachment_id_seq")
public class Proposal {

    @Id
    @Column(name = "doc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Personnel> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public Proposal(String title, String comment, List<Personnel> personnel, List<Attachment> attachment) {
        this.title = title;
        this.comment = comment;
        this.personnel = personnel;
        this.attachment = attachment;
    }

    public Proposal(String title, String comment) {
        this.title = title;
        this.comment = comment;

    }

    public Proposal() {
    }

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "comment", length = 1000)
    private String comment;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @CollectionId(
            columns = @Column(name = "personnel_attachment_id"),
            type = @Type(type = "long"),
            generator = "personnel_attachment_id_seq"
    )
    private List<Personnel> personnel;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "Proposal_id")
    private List<Attachment> attachment;

}
