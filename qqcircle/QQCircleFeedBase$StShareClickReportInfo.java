package qqcircle;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StShareClickReportInfo extends MessageMicro<QQCircleFeedBase$StShareClickReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"imei", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, PreloadTRTCPlayerParams.KEY_SIG, "userIP", "guid", "qimei36", "idfa"}, new Object[]{"", "", "", "", ByteStringMicro.EMPTY, "", ""}, QQCircleFeedBase$StShareClickReportInfo.class);
    public final PBStringField imei = PBField.initString("");
    public final PBStringField qimei = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
    public final PBStringField userIP = PBField.initString("");
    public final PBBytesField guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField qimei36 = PBField.initString("");
    public final PBStringField idfa = PBField.initString("");
}
