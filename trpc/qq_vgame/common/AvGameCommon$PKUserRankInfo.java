package trpc.qq_vgame.common;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGameCommon$PKUserRankInfo extends MessageMicro<AvGameCommon$PKUserRankInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"rank", "uin", LocalPhotoFaceInfo.SCORE}, new Object[]{0, 0L, 0}, AvGameCommon$PKUserRankInfo.class);
    public final PBUInt32Field rank = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
}
