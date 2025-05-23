package qqcircle;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankingstore$RankUserInfoStore extends MessageMicro<QQCircleRankingstore$RankUserInfoStore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"uid", LocalPhotoFaceInfo.SCORE, "grade", "rank"}, new Object[]{"", 0, 0, 0}, QQCircleRankingstore$RankUserInfoStore.class);
    public final PBStringField uid = PBField.initString("");
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt32Field grade = PBField.initInt32(0);
    public final PBInt32Field rank = PBField.initInt32(0);
}
