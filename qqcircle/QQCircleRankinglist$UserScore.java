package qqcircle;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$UserScore extends MessageMicro<QQCircleRankinglist$UserScore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uid", LocalPhotoFaceInfo.SCORE, "deltaScore"}, new Object[]{"", 0L, 0L}, QQCircleRankinglist$UserScore.class);
    public final PBStringField uid = PBField.initString("");
    public final PBInt64Field score = PBField.initInt64(0);
    public final PBInt64Field deltaScore = PBField.initInt64(0);
}
