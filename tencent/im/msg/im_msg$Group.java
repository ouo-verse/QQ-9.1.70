package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg$Group extends MessageMicro<im_msg$Group> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"sender", "receiver", "group_info"}, new Object[]{null, null, null}, im_msg$Group.class);
    public im_common$User sender = new im_common$User();
    public im_common$User receiver = new im_common$User();
    public im_common$GroupInfo group_info = new im_common$GroupInfo();
}
