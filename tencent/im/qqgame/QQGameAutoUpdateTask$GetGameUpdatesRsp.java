package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameAutoUpdateTask$GetGameUpdatesRsp extends MessageMicro<QQGameAutoUpdateTask$GetGameUpdatesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56}, new String[]{"ret", "msg", "update_games", "circle_game_config", "update_gap_druation", "king_switch", "min_electricity"}, new Object[]{0, "", null, null, 0L, 0, 0}, QQGameAutoUpdateTask$GetGameUpdatesRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436030msg = PBField.initString("");
    public final PBRepeatMessageField<QQGameAutoUpdateTask$PreUpdateInfo> update_games = PBField.initRepeatMessage(QQGameAutoUpdateTask$PreUpdateInfo.class);
    public QQGameAutoUpdateTask$CircleGameConfig circle_game_config = new QQGameAutoUpdateTask$CircleGameConfig();
    public final PBInt64Field update_gap_druation = PBField.initInt64(0);
    public final PBInt32Field king_switch = PBField.initInt32(0);
    public final PBInt32Field min_electricity = PBField.initInt32(0);
}
