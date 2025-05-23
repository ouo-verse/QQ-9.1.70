package tencent.im.oidb.search;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RequestSearchWord$Rcmd extends MessageMicro<RequestSearchWord$Rcmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 29, 34, 40}, new String[]{"word", "jmp_url", LocalPhotoFaceInfo.SCORE, "modle_name", "modle_id"}, new Object[]{ByteStringMicro.EMPTY, "", Float.valueOf(0.0f), "", 0}, RequestSearchWord$Rcmd.class);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField jmp_url = PBField.initString("");
    public final PBFloatField score = PBField.initFloat(0.0f);
    public final PBStringField modle_name = PBField.initString("");
    public final PBUInt32Field modle_id = PBField.initUInt32(0);
}
