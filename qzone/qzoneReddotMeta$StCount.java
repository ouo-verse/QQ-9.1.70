package qzone;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneReddotMeta$StCount extends MessageMicro<qzoneReddotMeta$StCount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"count", AlbumCacheData.CREATE_TIME}, new Object[]{0, 0L}, qzoneReddotMeta$StCount.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
}
