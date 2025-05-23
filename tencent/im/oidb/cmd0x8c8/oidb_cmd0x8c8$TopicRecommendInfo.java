package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$TopicRecommendInfo extends MessageMicro<oidb_cmd0x8c8$TopicRecommendInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name;
    public final PBBytesField bytes_business_name_prefix;
    public final PBBytesField bytes_business_url;
    public final PBBytesField bytes_pic_url;
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_of_participants;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "uint32_number_of_participants", "bytes_pic_url"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro}, oidb_cmd0x8c8$TopicRecommendInfo.class);
    }

    public oidb_cmd0x8c8$TopicRecommendInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_business_name = PBField.initBytes(byteStringMicro);
        this.bytes_business_url = PBField.initBytes(byteStringMicro);
        this.bytes_business_name_prefix = PBField.initBytes(byteStringMicro);
        this.uint32_number_of_participants = PBField.initUInt32(0);
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
    }
}
