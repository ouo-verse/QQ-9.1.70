package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameMakeTeamInfo$QueryGameTeamInfoRsp extends MessageMicro<QQGameMakeTeamInfo$QueryGameTeamInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"teams", "conf"}, new Object[]{null, null}, QQGameMakeTeamInfo$QueryGameTeamInfoRsp.class);
    public final PBRepeatMessageField<QQGameMakeTeamInfo$TeamInfo> teams = PBField.initRepeatMessage(QQGameMakeTeamInfo$TeamInfo.class);
    public QQGameMakeTeamInfo$Config conf = new MessageMicro<QQGameMakeTeamInfo$Config>() { // from class: tencent.im.qqgame.QQGameMakeTeamInfo$Config
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"expire", "max_req_teams", "req_interval"}, new Object[]{0, 0, 0}, QQGameMakeTeamInfo$Config.class);
        public final PBInt32Field expire = PBField.initInt32(0);
        public final PBInt32Field max_req_teams = PBField.initInt32(0);
        public final PBInt32Field req_interval = PBField.initInt32(0);
    };
}
