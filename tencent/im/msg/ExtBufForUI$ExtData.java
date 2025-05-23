package tencent.im.msg;

import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ExtBufForUI$ExtData extends MessageMicro<ExtBufForUI$ExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"zplan", "paiyipai", IPublicAccountJavascriptInterface.NAME_SPACE, "msgReply"}, new Object[]{null, null, null, null}, ExtBufForUI$ExtData.class);
    public ExtBufForUI$ZPlan zplan = new ExtBufForUI$ZPlan();
    public ExtBufForUI$PaiYiPai paiyipai = new ExtBufForUI$PaiYiPai();
    public ExtBufForUI$PublicAccount publicAccount = new ExtBufForUI$PublicAccount();
    public ExtBufForUI$MsgReply msgReply = new ExtBufForUI$MsgReply();
}
