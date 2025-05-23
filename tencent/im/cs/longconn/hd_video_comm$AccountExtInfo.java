package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$AccountExtInfo extends MessageMicro<hd_video_comm$AccountExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_common_info"}, new Object[]{null}, hd_video_comm$AccountExtInfo.class);
    public hd_video_comm$CommonInfo msg_common_info = new MessageMicro<hd_video_comm$CommonInfo>() { // from class: tencent.im.cs.longconn.hd_video_comm$CommonInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_account;
        public final PBBytesField bytes_ext_business_info;
        public final PBUInt32Field uint32_ext_business_type;
        public final PBUInt32Field uint32_source;
        public final PBUInt64Field uint64_account = PBField.initUInt64(0);
        public final PBUInt64Field uint64_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48}, new String[]{"uint64_account", "bytes_account", "uint32_source", "uint32_ext_business_type", "bytes_ext_business_info", "uint64_uin"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, 0L}, hd_video_comm$CommonInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_account = PBField.initBytes(byteStringMicro);
            this.uint32_source = PBField.initUInt32(0);
            this.uint32_ext_business_type = PBField.initUInt32(0);
            this.bytes_ext_business_info = PBField.initBytes(byteStringMicro);
            this.uint64_uin = PBField.initUInt64(0L);
        }
    };
}
