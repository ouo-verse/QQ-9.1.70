package tencent.im.oidb.qqmusic;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MusicSongInfoMatch$CMsgRequest extends MessageMicro<MusicSongInfoMatch$CMsgRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uin", LinkReportConstant$GlobalKey.CONNECT_TYPE, "cv", "reqtype", "urlparams"}, new Object[]{0L, 0L, 0L, 0, null}, MusicSongInfoMatch$CMsgRequest.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: ct, reason: collision with root package name */
    public final PBUInt64Field f436021ct = PBField.initUInt64(0);

    /* renamed from: cv, reason: collision with root package name */
    public final PBUInt64Field f436022cv = PBField.initUInt64(0);
    public final PBUInt32Field reqtype = PBField.initUInt32(0);
    public final PBRepeatMessageField<MusicSongInfoMatch$ParamPair> urlparams = PBField.initRepeatMessage(MusicSongInfoMatch$ParamPair.class);
}
