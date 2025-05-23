package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneReddotMeta$CacheInfo extends MessageMicro<qzoneReddotMeta$CacheInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cache_list"}, new Object[]{null}, qzoneReddotMeta$CacheInfo.class);
    public final PBRepeatMessageField<qzoneReddotMeta$ReddotCache> cache_list = PBField.initRepeatMessage(qzoneReddotMeta$ReddotCache.class);
}
