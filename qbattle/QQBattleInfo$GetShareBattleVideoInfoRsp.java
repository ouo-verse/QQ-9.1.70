package qbattle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQBattleInfo$GetShareBattleVideoInfoRsp extends MessageMicro<QQBattleInfo$GetShareBattleVideoInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"battle_id", "timestamp", "titles", "player", "mates", "opponents"}, new Object[]{null, "", "", null, null, null}, QQBattleInfo$GetShareBattleVideoInfoRsp.class);
    public QQBattleInfo$BattleID battle_id = new QQBattleInfo$BattleID();
    public final PBStringField timestamp = PBField.initString("");
    public final PBRepeatField<String> titles = PBField.initRepeat(PBStringField.__repeatHelper__);
    public QQBattleInfo$PlayerInfo player = new MessageMicro<QQBattleInfo$PlayerInfo>() { // from class: qbattle.QQBattleInfo$PlayerInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 74}, new String[]{"open_id", "uin", "nickname", "icon_url", "rank", "kill_cnt", "dead_cnt", "assist_cnt", "hero"}, new Object[]{"", "", "", "", 0, 0, 0, 0, null}, QQBattleInfo$PlayerInfo.class);
        public final PBStringField open_id = PBField.initString("");
        public final PBStringField uin = PBField.initString("");
        public final PBStringField nickname = PBField.initString("");
        public final PBStringField icon_url = PBField.initString("");
        public final PBEnumField rank = PBField.initEnum(0);
        public final PBInt32Field kill_cnt = PBField.initInt32(0);
        public final PBInt32Field dead_cnt = PBField.initInt32(0);
        public final PBInt32Field assist_cnt = PBField.initInt32(0);
        public QQBattleInfo$HeroInfo hero = new MessageMicro<QQBattleInfo$HeroInfo>() { // from class: qbattle.QQBattleInfo$HeroInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"id", "name", "rank", "rank_type", "skin_id"}, new Object[]{0, "", 0, 0, 0}, QQBattleInfo$HeroInfo.class);

            /* renamed from: id, reason: collision with root package name */
            public final PBInt32Field f428795id = PBField.initInt32(0);
            public final PBStringField name = PBField.initString("");
            public final PBInt32Field rank = PBField.initInt32(0);
            public final PBEnumField rank_type = PBField.initEnum(0);
            public final PBInt32Field skin_id = PBField.initInt32(0);
        };
    };
    public final PBRepeatMessageField<QQBattleInfo$PlayerInfo> mates = PBField.initRepeatMessage(QQBattleInfo$PlayerInfo.class);
    public final PBRepeatMessageField<QQBattleInfo$PlayerInfo> opponents = PBField.initRepeatMessage(QQBattleInfo$PlayerInfo.class);
}
