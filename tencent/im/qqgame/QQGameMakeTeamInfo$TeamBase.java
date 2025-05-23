package tencent.im.qqgame;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameMakeTeamInfo$TeamBase extends MessageMicro<QQGameMakeTeamInfo$TeamBase> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, n.CTRL_INDEX}, new String[]{"appid", "team_bus_id", "team_id", "captain", TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP, "ark_meta", "msg_seq"}, new Object[]{"", "", "", null, 0L, "", ""}, QQGameMakeTeamInfo$TeamBase.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField team_bus_id = PBField.initString("");
    public final PBStringField team_id = PBField.initString("");
    public QQGameMakeTeamInfo$PersonalInfo captain = new MessageMicro<QQGameMakeTeamInfo$PersonalInfo>() { // from class: tencent.im.qqgame.QQGameMakeTeamInfo$PersonalInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"openid", "plat_id", GdtGetUserInfoHandler.KEY_AREA, "partition"}, new Object[]{"", 0, 0, 0}, QQGameMakeTeamInfo$PersonalInfo.class);
        public final PBStringField openid = PBField.initString("");
        public final PBInt32Field plat_id = PBField.initInt32(0);
        public final PBInt32Field area = PBField.initInt32(0);
        public final PBInt32Field partition = PBField.initInt32(0);
    };

    /* renamed from: tm, reason: collision with root package name */
    public final PBInt64Field f436037tm = PBField.initInt64(0);
    public final PBStringField ark_meta = PBField.initString("");
    public final PBStringField msg_seq = PBField.initString("");
}
