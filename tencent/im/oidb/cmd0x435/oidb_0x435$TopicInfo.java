package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x435$TopicInfo extends MessageMicro<oidb_0x435$TopicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_topic_name", "rpt_msg_pkitems"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x435$TopicInfo.class);
    public final PBBytesField bytes_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x435$PKItem> rpt_msg_pkitems = PBField.initRepeatMessage(oidb_0x435$PKItem.class);
}
