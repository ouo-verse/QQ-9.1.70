package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd46$KsSubscribedList extends MessageMicro<oidb_cmd0xd46$KsSubscribedList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_subscribed_count", "msg_ks_banner_info", "rpt_msg_ks_topic_list"}, new Object[]{0, null, null}, oidb_cmd0xd46$KsSubscribedList.class);
    public final PBUInt32Field uint32_subscribed_count = PBField.initUInt32(0);
    public oidb_cmd0xd46$KsBannerInfo msg_ks_banner_info = new MessageMicro<oidb_cmd0xd46$KsBannerInfo>() { // from class: tencent.im.oidb.cmd0xd46.oidb_cmd0xd46$KsBannerInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_title", "uint32_jump_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_cmd0xd46$KsBannerInfo.class);
        public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<oidb_cmd0xd46$KsTopicInfo> rpt_msg_ks_topic_list = PBField.initRepeatMessage(oidb_cmd0xd46$KsTopicInfo.class);
}
