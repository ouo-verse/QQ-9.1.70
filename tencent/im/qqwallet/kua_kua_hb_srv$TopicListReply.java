package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class kua_kua_hb_srv$TopicListReply extends MessageMicro<kua_kua_hb_srv$TopicListReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"retCode", "retMsg", "topicList"}, new Object[]{0L, "", null}, kua_kua_hb_srv$TopicListReply.class);
    public final PBInt64Field retCode = PBField.initInt64(0);
    public final PBStringField retMsg = PBField.initString("");
    public final PBRepeatMessageField<kua_kua_hb_srv$TopicAttr> topicList = PBField.initRepeatMessage(kua_kua_hb_srv$TopicAttr.class);
}
