package tencent.im.qqgame;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameMakeTeamInfo$TeamInfo extends MessageMicro<QQGameMakeTeamInfo$TeamInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 72, 82, n.CTRL_INDEX}, new String[]{"appid", "team_bus_id", "team_id", "status", "icons", "main_text", "sub_text", "jump_url", TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP, "subscribe_id", "msg_seq"}, new Object[]{"", "", "", 0, "", "", "", "", 0L, "", ""}, QQGameMakeTeamInfo$TeamInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField team_bus_id = PBField.initString("");
    public final PBStringField team_id = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField main_text = PBField.initString("");
    public final PBStringField sub_text = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");

    /* renamed from: tm, reason: collision with root package name */
    public final PBInt64Field f436038tm = PBField.initInt64(0);
    public final PBStringField subscribe_id = PBField.initString("");
    public final PBStringField msg_seq = PBField.initString("");
}
