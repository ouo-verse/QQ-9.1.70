package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankingstore$RankInfoStore extends MessageMicro<QQCircleRankingstore$RankInfoStore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ITVKPlayerEventListener.KEY_USER_INFO}, new Object[]{null}, QQCircleRankingstore$RankInfoStore.class);
    public final PBRepeatMessageField<QQCircleRankingstore$RankUserInfoStore> userInfo = PBField.initRepeatMessage(QQCircleRankingstore$RankUserInfoStore.class);
}
