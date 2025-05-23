package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$State extends MessageMicro<mutualmark$State> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"info", "status"}, new Object[]{null, null}, mutualmark$State.class);
    public mutualmark$Info info = new mutualmark$Info();
    public mutualmark$Status status = new mutualmark$Status();
}
