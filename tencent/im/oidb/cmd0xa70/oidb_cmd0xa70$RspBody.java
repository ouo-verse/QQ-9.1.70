package tencent.im.oidb.cmd0xa70;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa70$RspBody extends MessageMicro<oidb_cmd0xa70$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"msg_video_rsp_info"}, new Object[]{null}, oidb_cmd0xa70$RspBody.class);
    public oidb_cmd0xa70$VideoRspInfo msg_video_rsp_info = new MessageMicro<oidb_cmd0xa70$VideoRspInfo>() { // from class: tencent.im.oidb.cmd0xa70.oidb_cmd0xa70$VideoRspInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_business_name;
        public final PBBytesField bytes_business_name_prefix;
        public final PBBytesField bytes_business_url;
        public final PBBytesField bytes_desc;
        public final PBBytesField bytes_pic_url;
        public final PBBytesField bytes_title;
        public final PBBytesField bytes_uuid;
        public final PBBytesField bytes_video_url;
        public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pic_height;
        public final PBUInt32Field uint32_pic_width;
        public final PBUInt64Field uint64_duration;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 90, 98, 106, 114, 122, 128, 136, 144}, new String[]{"uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "bytes_title", "bytes_desc", "bytes_uuid", "bytes_video_url", "bytes_pic_url", "uint32_pic_height", "uint32_pic_width", "uint64_duration"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0L}, oidb_cmd0xa70$VideoRspInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_business_name = PBField.initBytes(byteStringMicro);
            this.bytes_business_url = PBField.initBytes(byteStringMicro);
            this.bytes_business_name_prefix = PBField.initBytes(byteStringMicro);
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.bytes_desc = PBField.initBytes(byteStringMicro);
            this.bytes_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_video_url = PBField.initBytes(byteStringMicro);
            this.bytes_pic_url = PBField.initBytes(byteStringMicro);
            this.uint32_pic_height = PBField.initUInt32(0);
            this.uint32_pic_width = PBField.initUInt32(0);
            this.uint64_duration = PBField.initUInt64(0L);
        }
    };
}
