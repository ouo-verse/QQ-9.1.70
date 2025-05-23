package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$ReqBody extends MessageMicro<oidb_0x8dd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field areaStat;
    public final PBBytesField bytes_cookie;
    public final PBBytesField bytes_qq_version;
    public final PBBytesField bytes_recommend_cookie;
    public final PBBytesField bytes_req_ad;
    public final PBUInt64Field code;
    public oidb_0x8dd$Filter msg_filter;
    public oidb_0x8dd$LBSInfo msg_lbs_info;
    public oidb_0x8dd$ReqCtrl msg_req_ctrl;
    public final PBUInt32Field uint32_client_type;
    public final PBUInt32Field uint32_client_version;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_source_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 58, 64, 72, 80, 90, 96, 104, 114}, new String[]{"bytes_cookie", "uint32_source_type", "msg_lbs_info", "msg_filter", "bytes_req_ad", "msg_req_ctrl", "uint32_gender", "uint32_client_version", "uint32_client_type", "bytes_qq_version", "code", "areaStat", "bytes_recommend_cookie"}, new Object[]{byteStringMicro, 0, null, null, byteStringMicro, null, 0, 0, 0, byteStringMicro, 0L, 0, byteStringMicro}, oidb_0x8dd$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [tencent.im.oidb.cmd0x8dd.oidb_0x8dd$Filter] */
    /* JADX WARN: Type inference failed for: r2v4, types: [tencent.im.oidb.cmd0x8dd.oidb_0x8dd$ReqCtrl] */
    public oidb_0x8dd$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
        this.uint32_source_type = PBField.initUInt32(0);
        this.msg_lbs_info = new oidb_0x8dd$LBSInfo();
        this.msg_filter = new MessageMicro<oidb_0x8dd$Filter>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$Filter
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72}, new String[]{"uint32_gender", "uint32_time_interval", "uint32_age_up", "uint32_age_low", "uint32_interest", "uint64_sub_interest", "uint32_profession", "msg_hometown", "uint32_constellation"}, new Object[]{0, 0, 0, 0, 0, 0L, 0, null, 0}, oidb_0x8dd$Filter.class);
            public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
            public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
            public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
            public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
            public final PBUInt32Field uint32_interest = PBField.initUInt32(0);
            public final PBUInt64Field uint64_sub_interest = PBField.initUInt64(0);
            public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
            public oidb_0x8dd$Hometown msg_hometown = new MessageMicro<oidb_0x8dd$Hometown>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$Hometown
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_country", "uint32_province", "uint32_city"}, new Object[]{0, 0, 0}, oidb_0x8dd$Hometown.class);
                public final PBUInt32Field uint32_country = PBField.initUInt32(0);
                public final PBUInt32Field uint32_province = PBField.initUInt32(0);
                public final PBUInt32Field uint32_city = PBField.initUInt32(0);
            };
            public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
        };
        this.bytes_req_ad = PBField.initBytes(byteStringMicro);
        this.msg_req_ctrl = new MessageMicro<oidb_0x8dd$ReqCtrl>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$ReqCtrl
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104}, new String[]{"uint32_req_uin", "uint32_req_tinyid", "uint32_req_anchor", "uint32_req_ad", "uint32_req_self", "uint32_req_safe", "uint32_req_check_in", "uint32_req_people_number", "uint32_req_none", "uint32_req_third_line", "uint32_req_sort_algorithm", "uint32_req_from_web", "uint32_req_recommend_cookie"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, oidb_0x8dd$ReqCtrl.class);
            public final PBUInt32Field uint32_req_uin = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_tinyid = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_anchor = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_ad = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_self = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_safe = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_check_in = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_people_number = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_none = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_third_line = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_sort_algorithm = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_from_web = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_recommend_cookie = PBField.initUInt32(0);
        };
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_client_version = PBField.initUInt32(0);
        this.uint32_client_type = PBField.initUInt32(0);
        this.bytes_qq_version = PBField.initBytes(byteStringMicro);
        this.code = PBField.initUInt64(0L);
        this.areaStat = PBField.initInt32(0);
        this.bytes_recommend_cookie = PBField.initBytes(byteStringMicro);
    }
}
