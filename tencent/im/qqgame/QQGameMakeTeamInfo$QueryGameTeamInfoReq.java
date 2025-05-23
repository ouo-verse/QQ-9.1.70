package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameMakeTeamInfo$QueryGameTeamInfoReq extends MessageMicro<QQGameMakeTeamInfo$QueryGameTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"teams"}, new Object[]{null}, QQGameMakeTeamInfo$QueryGameTeamInfoReq.class);
    public final PBRepeatMessageField<QQGameMakeTeamInfo$TeamBase> teams = PBField.initRepeatMessage(QQGameMakeTeamInfo$TeamBase.class);
}
