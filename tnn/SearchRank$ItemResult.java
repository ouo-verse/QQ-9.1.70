package tnn;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SearchRank$ItemResult extends MessageMicro<SearchRank$ItemResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 26}, new String[]{"uin", LocalPhotoFaceInfo.SCORE, "matched_field"}, new Object[]{"", Float.valueOf(0.0f), ""}, SearchRank$ItemResult.class);
    public final PBStringField uin = PBField.initString("");
    public final PBFloatField score = PBField.initFloat(0.0f);
    public final PBStringField matched_field = PBField.initString("");
}
