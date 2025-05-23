package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicInfoReq extends MessageMicro<QQCircleSmartMatchMusic$MusicInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> musicMIDList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField fromCache = PBField.initBool(false);
    public final PBBoolField disableLyricsTranslation = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "musicMIDList", "fromCache", "disableLyricsTranslation"}, new Object[]{null, "", bool, bool}, QQCircleSmartMatchMusic$MusicInfoReq.class);
    }
}
