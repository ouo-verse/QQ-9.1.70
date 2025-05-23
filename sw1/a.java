package sw1;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import mqq.app.AppRuntime;
import sw1.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bJ \u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bJ4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a8\u0006!"}, d2 = {"Lsw1/a;", "Lsw1/g;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElem", "k", "l", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "a", "curType", "Landroid/content/Intent;", h.F, "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "j", "", "isCompleted", "f", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements g {
    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (!(msgElement == null && (msgElement = k.f415564a.d(msgRecord)) == null) && ah.o0(msgElement.fileElement.fileName) == 0) {
            int i3 = type == 1 ? 2 : 1;
            i(msgRecord, msgElement.elementId, i3, i3 == 2 ? 750 : 0);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void b(MsgRecord msgRecord, int i3, int i16, MsgElement msgElement, int i17, int i18, VideoCodecFormatType videoCodecFormatType, i iVar) {
        g.a.c(this, msgRecord, i3, i16, msgElement, i17, i18, videoCodecFormatType, iVar);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public List<AIORichMediaData> c(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement, int subId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList arrayList = new ArrayList();
        if (msgElement == null && (msgElement = k.f415564a.d(msgRecord)) == null) {
            return arrayList;
        }
        FileElement fileElem = msgElement.fileElement;
        int o06 = ah.o0(fileElem.fileName);
        if (o06 == 0) {
            Intrinsics.checkNotNullExpressionValue(fileElem, "fileElem");
            AIORichMediaData k3 = k(app, msgRecord, fileElem, 0);
            if (k3 != null) {
                arrayList.add(k3);
            }
        } else if (o06 == 2) {
            Intrinsics.checkNotNullExpressionValue(fileElem, "fileElem");
            AIORichMediaData l3 = l(msgRecord, fileElem, 0);
            if (l3 != null) {
                arrayList.add(l3);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean d(ChatMessage chatMessage, MsgRecord msgRecord, QBaseActivity qBaseActivity, AppRuntime appRuntime) {
        return g.a.g(this, chatMessage, msgRecord, qBaseActivity, appRuntime);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean e(int i3, int i16) {
        return g.a.a(this, i3, i16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public int f(MsgRecord msgRecord, int type, boolean isCompleted) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement d16 = k.f415564a.d(msgRecord);
        FileElement fileElement = d16 != null ? d16.fileElement : null;
        return ah.o0(fileElement != null ? fileElement.fileName : null) == 2 ? isCompleted ? 269484034 : 269484035 : type;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = k.f415564a.d(msgRecord)) == null) {
            return;
        }
        int i3 = type == 1 ? 2 : 1;
        m(msgRecord, msgElement, i3, i3 == 2 ? 750 : 0);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = k.f415564a.d(msgRecord)) == null) {
            return null;
        }
        FileElement fileElem = msgElement.fileElement;
        Intent intent = new Intent();
        intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putBoolean("not_forward", true);
        Intrinsics.checkNotNullExpressionValue(fileElem, "fileElem");
        bundle.putParcelable("fileinfo", j(msgRecord, fileElem));
        bundle.putString(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.f1326742) + FileManagerUtil.cutLongName(fileElem.fileName) + HardCodeUtil.qqStr(R.string.f1326843) + q.g(fileElem.fileSize) + "\u3002");
        bundle.putBoolean("direct_send_if_dataline_forward", true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, fileElem.filePath);
        intent.putExtras(bundle);
        intent.putExtra("extra.MSG_ID", msgRecord.msgId);
        intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, msgRecord.chatType);
        intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_ID, msgRecord.guildId);
        intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID, msgRecord.channelId);
        return intent;
    }

    public void i(MsgRecord msgRecord, long j3, int i3, int i16) {
        g.a.b(this, msgRecord, j3, i3, i16);
    }

    @Override // sw1.g
    public boolean isSelfGuest(String str, String str2) {
        return g.a.f(this, str, str2);
    }

    public final ForwardFileInfo j(MsgRecord msgRecord, FileElement fileElem) {
        Object first;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElem, "fileElem");
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(10000);
        forwardFileInfo.V(msgRecord.msgId);
        forwardFileInfo.y(fileElem.fileName);
        forwardFileInfo.z(fileElem.fileSize);
        forwardFileInfo.C(fileElem.filePath);
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            forwardFileInfo.G((String) first);
        }
        return forwardFileInfo;
    }

    public final AIORichMediaData k(AppRuntime app, MsgRecord msgRecord, FileElement fileElem, int subId) {
        Object first;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElem, "fileElem");
        AIOFilePicData aIOFilePicData = new AIOFilePicData();
        rw1.e.f432610a.a(msgRecord, aIOFilePicData);
        aIOFilePicData.F = msgRecord.peerUid;
        aIOFilePicData.C = false;
        aIOFilePicData.U = app.getCurrentAccountUin();
        aIOFilePicData.G = 10014;
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2) {
            aIOFilePicData.V = 1;
        }
        aIOFilePicData.f179631h = fileElem.fileSize;
        aIOFilePicData.Z = fileElem.fileMd5;
        Integer num = fileElem.picWidth;
        Intrinsics.checkNotNullExpressionValue(num, "fileElem.picWidth");
        aIOFilePicData.f179567a0 = num.intValue();
        Integer num2 = fileElem.picHeight;
        Intrinsics.checkNotNullExpressionValue(num2, "fileElem.picHeight");
        aIOFilePicData.f179568b0 = num2.intValue();
        Integer num3 = fileElem.invalidState;
        Intrinsics.checkNotNullExpressionValue(num3, "fileElem.invalidState");
        aIOFilePicData.f179569c0 = num3.intValue();
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            aIOFilePicData.H = (String) first;
        }
        if (TextUtils.isEmpty(fileElem.filePath)) {
            aIOFilePicData.J = AIOBrowserBaseData.MEDIA_FILE_NONE;
            aIOFilePicData.I = AIOBrowserBaseData.MEDIA_FILE_NONE;
        } else {
            String str = fileElem.filePath;
            aIOFilePicData.I = str;
            aIOFilePicData.J = str;
        }
        aIOFilePicData.W = fileElem.fileName;
        Integer num4 = fileElem.invalidState;
        aIOFilePicData.Q = num4 == null || num4.intValue() != 0;
        aIOFilePicData.R = fileElem.fileSize;
        aIOFilePicData.f179629e = subId;
        return aIOFilePicData;
    }

    public final AIORichMediaData l(MsgRecord msgRecord, FileElement fileElem, int subId) {
        Object first;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElem, "fileElem");
        Integer num = fileElem.invalidState;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        if (num == null || num.intValue() != 0) {
            QLog.i("AIOFileProvider", 1, "createVideoMediaData. id: " + msgRecord.msgId + " file is invalid!");
            return null;
        }
        AIOFileVideoData aIOFileVideoData = new AIOFileVideoData();
        aIOFileVideoData.U = msgRecord.peerUid;
        aIOFileVideoData.f179628d = msgRecord.msgId;
        aIOFileVideoData.f179630f = msgRecord.msgTime;
        aIOFileVideoData.f179632i = msgRecord.msgSeq;
        aIOFileVideoData.V = 10014;
        aIOFileVideoData.f179633m = 10014;
        aIOFileVideoData.C = false;
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2) {
            aIOFileVideoData.W = 1;
        }
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            aIOFileVideoData.G = (String) first;
        }
        aIOFileVideoData.Y = fileElem.fileMd5;
        aIOFileVideoData.f179631h = fileElem.fileSize;
        aIOFileVideoData.F = fileElem.fileName;
        Integer num2 = fileElem.picHeight;
        Intrinsics.checkNotNullExpressionValue(num2, "fileElem.picHeight");
        aIOFileVideoData.K = num2.intValue();
        Integer num3 = fileElem.picWidth;
        Intrinsics.checkNotNullExpressionValue(num3, "fileElem.picWidth");
        aIOFileVideoData.J = num3.intValue();
        if (FileUtils.fileExistsAndNotEmpty(fileElem.filePath)) {
            aIOFileVideoData.H = fileElem.filePath;
            aIOFileVideoData.P = true;
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever3 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever3.setDataSource(aIOFileVideoData.H);
                        String extractMetadata = mediaMetadataRetriever3.extractMetadata(24);
                        String extractMetadata2 = mediaMetadataRetriever3.extractMetadata(19);
                        String extractMetadata3 = mediaMetadataRetriever3.extractMetadata(18);
                        Intrinsics.checkNotNull(extractMetadata);
                        int parseInt = Integer.parseInt(extractMetadata);
                        if (parseInt != 90 && parseInt != 270) {
                            Intrinsics.checkNotNull(extractMetadata3);
                            aIOFileVideoData.J = Integer.parseInt(extractMetadata3);
                            Intrinsics.checkNotNull(extractMetadata2);
                            aIOFileVideoData.K = Integer.parseInt(extractMetadata2);
                        } else {
                            Intrinsics.checkNotNull(extractMetadata2);
                            aIOFileVideoData.J = Integer.parseInt(extractMetadata2);
                            Intrinsics.checkNotNull(extractMetadata3);
                            aIOFileVideoData.K = Integer.parseInt(extractMetadata3);
                        }
                        mediaMetadataRetriever3.release();
                        mediaMetadataRetriever = extractMetadata2;
                    } catch (Exception e16) {
                        e = e16;
                        mediaMetadataRetriever2 = mediaMetadataRetriever3;
                        e.printStackTrace();
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        if (mediaMetadataRetriever2 != null) {
                            mediaMetadataRetriever2.release();
                            mediaMetadataRetriever = mediaMetadataRetriever2;
                        }
                        aIOFileVideoData.f179629e = subId;
                        return aIOFileVideoData;
                    } catch (Throwable th5) {
                        th = th5;
                        mediaMetadataRetriever = mediaMetadataRetriever3;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        aIOFileVideoData.f179629e = subId;
        return aIOFileVideoData;
    }

    public void m(MsgRecord msgRecord, MsgElement msgElement, int i3, int i16) {
        g.a.d(this, msgRecord, msgElement, i3, i16);
    }
}
