package tnn;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SearchRank$NodeResult extends MessageMicro<SearchRank$NodeResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21}, new String[]{"node_id", LocalPhotoFaceInfo.SCORE}, new Object[]{0, Float.valueOf(0.0f)}, SearchRank$NodeResult.class);
    public final PBInt32Field node_id = PBField.initInt32(0);
    public final PBFloatField score = PBField.initFloat(0.0f);
}
