package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleInfo extends MessageMicro<YoloBattleMiniGameOuterClass$YoloMiniGameBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 32, 40, 50}, new String[]{"status", DownloadInfo.spKey_Config, VasQQSettingMeImpl.EXPIRE_TIME, "last_event_type", "extra_data"}, new Object[]{0, null, 0, 0, ""}, YoloBattleMiniGameOuterClass$YoloMiniGameBattleInfo.class);
    public final PBEnumField status = PBField.initEnum(0);
    public YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig config = new YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig();
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBEnumField last_event_type = PBField.initEnum(0);
    public final PBStringField extra_data = PBField.initString("");
}
