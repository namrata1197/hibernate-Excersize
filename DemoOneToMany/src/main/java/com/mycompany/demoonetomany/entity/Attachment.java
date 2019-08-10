package com.mycompany.demoonetomany.entity;

import java.sql.Timestamp;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author namrata
 */
@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
//    @Column(name = "aid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filesize")
    private String filesize;

    @Column(name = "craeted")
    private Timestamp created;

    @Column(name = "attachementb_bytes")
    private byte attachementbBytes;

    public Attachment() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public byte getAttachementbBytes() {
        return attachementbBytes;
    }

    public void setAttachementbBytes(byte attachementbBytes) {
        this.attachementbBytes = attachementbBytes;
    }

    public Attachment(String filename, String filesize, Timestamp created, byte attachementbBytes) {
        this.filename = filename;
        this.filesize = filesize;
        this.created = created;
        this.attachementbBytes = attachementbBytes;
    }
}
