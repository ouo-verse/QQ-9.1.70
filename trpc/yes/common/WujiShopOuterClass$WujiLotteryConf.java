package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiShopOuterClass$WujiLotteryConf extends MessageMicro<WujiShopOuterClass$WujiLotteryConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56}, new String[]{"id", "name", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "lottery_img", "lottery_item_list", "cost_ticket_num"}, new Object[]{0, "", 0, 0, "", 0, 0}, WujiShopOuterClass$WujiLotteryConf.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f437253id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field begin_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBStringField lottery_img = PBField.initString("");
    public final PBRepeatField<Integer> lottery_item_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field cost_ticket_num = PBField.initInt32(0);
}
