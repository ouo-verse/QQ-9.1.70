package qqcircle;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankingstore$DovInfoStore extends MessageMicro<QQCircleRankingstore$DovInfoStore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"addtime", LocalPhotoFaceInfo.SCORE}, new Object[]{0L, 0}, QQCircleRankingstore$DovInfoStore.class);
    public final PBInt64Field addtime = PBField.initInt64(0);
    public final PBInt32Field score = PBField.initInt32(0);
}
