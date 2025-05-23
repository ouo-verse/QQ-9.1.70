package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class im_msg_body$PubAccInfo extends MessageMicro<im_msg_body$PubAccInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_is_inter_num", "string_msg_template_id", "string_long_msg_url", "bytes_download_key"}, new Object[]{0, "", "", ByteStringMicro.EMPTY}, im_msg_body$PubAccInfo.class);
    public final PBUInt32Field uint32_is_inter_num = PBField.initUInt32(0);
    public final PBStringField string_msg_template_id = PBField.initString("");
    public final PBStringField string_long_msg_url = PBField.initString("");
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
