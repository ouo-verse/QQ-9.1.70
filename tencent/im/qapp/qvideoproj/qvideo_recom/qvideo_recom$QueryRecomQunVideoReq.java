package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qvideo_recom$QueryRecomQunVideoReq extends MessageMicro<qvideo_recom$QueryRecomQunVideoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start_index", "end_index"}, new Object[]{0, 0}, qvideo_recom$QueryRecomQunVideoReq.class);
    public final PBUInt32Field start_index = PBField.initUInt32(0);
    public final PBUInt32Field end_index = PBField.initUInt32(0);
}
