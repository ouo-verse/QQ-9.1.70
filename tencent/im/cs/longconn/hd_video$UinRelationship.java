package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video$UinRelationship extends MessageMicro<hd_video$UinRelationship> {
    public static final int RT_DISCUSS = 2;
    public static final int RT_FRIEND = 1;
    public static final int RT_GROUP = 3;
    public static final int RT_OPENSDK = 6;
    public static final int RT_TEMP = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_relationship;
    public final PBBytesField bytes_relationship_ext;
    public final PBEnumField enum_termtype;
    public hd_video_comm$AccountExtInfo msg_account_ext_info;
    public hd_video$SigC2CData msg_sig_c2c_data;
    public final PBUInt32Field uint32_binded_id_type;
    public final PBUInt32Field uint32_relationship_id_type;
    public final PBUInt32Field uint32_status;
    public final PBUInt64Field uint64_binded_id;
    public final PBUInt64Field uint64_group_conf_uin;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_relation_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_relationship_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 64, 72, 82, 88, 96, 106}, new String[]{"uint64_uin", "enum_relation_type", "uint64_relationship_id", "bytes_relationship", "uint32_status", "enum_termtype", "msg_sig_c2c_data", "uint32_relationship_id_type", "uint64_group_conf_uin", "bytes_relationship_ext", "uint64_binded_id", "uint32_binded_id_type", "msg_account_ext_info"}, new Object[]{0L, 1, 0L, byteStringMicro, 0, 1, null, 0, 0L, byteStringMicro, 0L, 0, null}, hd_video$UinRelationship.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [tencent.im.cs.longconn.hd_video$SigC2CData] */
    public hd_video$UinRelationship() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_relationship = PBField.initBytes(byteStringMicro);
        this.uint32_status = PBField.initUInt32(0);
        this.enum_termtype = PBField.initEnum(1);
        this.msg_sig_c2c_data = new MessageMicro<hd_video$SigC2CData>() { // from class: tencent.im.cs.longconn.hd_video$SigC2CData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_result", "uint64_group_uin"}, new Object[]{0, 0L}, hd_video$SigC2CData.class);
            public final PBUInt32Field uint32_result = PBField.initUInt32(0);
            public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
        };
        this.uint32_relationship_id_type = PBField.initUInt32(0);
        this.uint64_group_conf_uin = PBField.initUInt64(0L);
        this.bytes_relationship_ext = PBField.initBytes(byteStringMicro);
        this.uint64_binded_id = PBField.initUInt64(0L);
        this.uint32_binded_id_type = PBField.initUInt32(0);
        this.msg_account_ext_info = new hd_video_comm$AccountExtInfo();
    }
}
