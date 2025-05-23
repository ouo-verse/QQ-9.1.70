package tencent.im.oidb.qqshop;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class qqshop$SQQSHPRecmdAccount extends MessageMicro<qqshop$SQQSHPRecmdAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "nick", "headurl", "desc"}, new Object[]{0L, "", "", ""}, qqshop$SQQSHPRecmdAccount.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField headurl = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
