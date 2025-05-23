package tencent.im.c2s.splashscreenad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SplashScreenAdReport$ReqBody extends MessageMicro<SplashScreenAdReport$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "msg_report"}, new Object[]{0L, null}, SplashScreenAdReport$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public SplashScreenAdReport$ReportMsg msg_report = new MessageMicro<SplashScreenAdReport$ReportMsg>() { // from class: tencent.im.c2s.splashscreenad.SplashScreenAdReport$ReportMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_ad_id", "uint32_action_type"}, new Object[]{"", 0}, SplashScreenAdReport$ReportMsg.class);
        public final PBStringField str_ad_id = PBField.initString("");
        public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    };
}
