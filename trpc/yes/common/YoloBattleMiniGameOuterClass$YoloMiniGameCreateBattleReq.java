package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleReq extends MessageMicro<YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 82}, new String[]{DownloadInfo.spKey_Config, "force_check_mode", "extra_data"}, new Object[]{null, 0, ""}, YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleReq.class);
    public YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig config = new YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig();
    public final PBInt32Field force_check_mode = PBField.initInt32(0);
    public final PBStringField extra_data = PBField.initString("");
}
