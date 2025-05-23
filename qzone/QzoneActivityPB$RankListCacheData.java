package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$RankListCacheData extends MessageMicro<QzoneActivityPB$RankListCacheData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ranks", "ts"}, new Object[]{null, 0L}, QzoneActivityPB$RankListCacheData.class);
    public final PBRepeatMessageField<QzoneActivityPB$UserPageInfo> ranks = PBField.initRepeatMessage(QzoneActivityPB$UserPageInfo.class);

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f430345ts = PBField.initInt64(0);
}
