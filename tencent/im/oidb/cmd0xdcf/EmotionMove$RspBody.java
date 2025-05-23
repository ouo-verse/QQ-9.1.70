package tencent.im.oidb.cmd0xdcf;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class EmotionMove$RspBody extends MessageMicro<EmotionMove$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "msg_order_filename"}, new Object[]{0, "", null}, EmotionMove$RspBody.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public EmotionMove$OrderFileResult msg_order_filename = new MessageMicro<EmotionMove$OrderFileResult>() { // from class: tencent.im.oidb.cmd0xdcf.EmotionMove$OrderFileResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 32, 40}, new String[]{"filename", "bid", "max_roam_size", "uint32_emoji_type"}, new Object[]{"", "", 0, 0}, EmotionMove$OrderFileResult.class);
        public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField bid = PBField.initString("");
        public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
        public final PBRepeatField<Integer> uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
}
