package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class im_msg_body$GroupPubAccountInfo extends MessageMicro<im_msg_body$GroupPubAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_pub_account"}, new Object[]{0L}, im_msg_body$GroupPubAccountInfo.class);
    public final PBUInt64Field uint64_pub_account = PBField.initUInt64(0);
}
