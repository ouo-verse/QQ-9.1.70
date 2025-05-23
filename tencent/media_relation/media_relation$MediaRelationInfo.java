package tencent.media_relation;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class media_relation$MediaRelationInfo extends MessageMicro<media_relation$MediaRelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"frd_uin", AlbumCacheData.CREATE_TIME}, new Object[]{0L, 0}, media_relation$MediaRelationInfo.class);
    public final PBUInt64Field frd_uin = PBField.initUInt64(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
}
