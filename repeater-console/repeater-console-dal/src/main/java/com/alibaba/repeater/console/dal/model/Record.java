package com.alibaba.repeater.console.dal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * {@link Record}
 * <p>
 *
 * @author zhaoyb1990
 */
@Entity
@Table(name = "record")
@Getter
@Setter
public class Record implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_record")
    private Date gmtRecord;

    @Column(name = "app_name")
    private String appName;

    private String environment;

    private String host;

    @Column(name = "trace_id")
    private String traceId;

    @Column(name = "entrance_desc")
    private String entranceDesc;

    @Column(name = "wrapper_record")
    private String wrapperRecord;

    private String request;

    private String response;

    /** 注解 @JsonIgnore 用于临时解决 ManyToOne 导致的死循环问题；
     * 参考 https://blog.csdn.net/qq_41621362/article/details/103997237
     */
    @JsonIgnore
    @OneToMany(mappedBy = "record", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Replay> replays;
}
