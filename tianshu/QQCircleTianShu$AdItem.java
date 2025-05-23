package tianshu;

import com.qq.e.comm.constants.TangramAppConstants;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTianShu$AdItem extends MessageMicro<QQCircleTianShu$AdItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 42, 82, 90, 98, 106, 114, 122, 162}, new String[]{"iAdId", MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, "title", "desc", "jumpurl", TangramAppConstants.ICON_URL, "lstPic", "argList", "ext_info"}, new Object[]{0, "", "", "", "", "", "", null, ""}, QQCircleTianShu$AdItem.class);
    public final PBUInt32Field iAdId = PBField.initUInt32(0);
    public final PBStringField traceinfo = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField jumpurl = PBField.initString("");
    public final PBStringField iconurl = PBField.initString("");
    public final PBRepeatField<String> lstPic = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<QQCircleTianShu$MapEntry> argList = PBField.initRepeatMessage(QQCircleTianShu$MapEntry.class);
    public final PBStringField ext_info = PBField.initString("");
}
