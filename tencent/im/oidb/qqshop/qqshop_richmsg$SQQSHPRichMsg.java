package tencent.im.oidb.qqshop;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class qqshop_richmsg$SQQSHPRichMsg extends MessageMicro<qqshop_richmsg$SQQSHPRichMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "msg_id", "sendtime", "img_url"}, new Object[]{0L, 0L, 0L, ""}, qqshop_richmsg$SQQSHPRichMsg.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt64Field msg_id = PBField.initUInt64(0);
    public final PBUInt64Field sendtime = PBField.initUInt64(0);
    public final PBRepeatField<String> img_url = PBField.initRepeat(PBStringField.__repeatHelper__);
}
